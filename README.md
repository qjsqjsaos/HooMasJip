# HooMasJip
- 현재 위치 근처로 블로그 맛집 후기 글을 빠르게 찾아드립니다. 
- 우연히 찾은 맛집 잊지 않도록 저장을 해드립니다.
- 나만의 맛집 지도를 완성할 수 있습니다. 

# 작업 순서 (내림차순 순서)
1. 후맛집 예상 기획 **[완료]** -> [기획 링크](https://www.figma.com/file/pMXqc6klaWrkOC0aiQ7U4a/%ED%9B%84%EB%A7%9B%EC%A7%91-%EA%B0%84%EB%8B%A8-%EA%B8%B0%ED%9A%8D?node-id=0%3A1)
2. Naver,Daum,Naver Map Api,Sdk 검토 **[완료]** -> [링크](https://www.figma.com/file/xudzmtv5eMUcZTPQtcQs3q/%ED%9B%84%EB%A7%9B%EC%A7%91-API%2CSDK-%EC%A0%95%EB%B3%B4?node-id=0%3A1)
3. 상세 기획 제작 (figma)
4. UI 디자인 제작(스타일 가이드, 재사용 컴포넌트)
5. 개발 셋팅 (Kts로 변화 , Library Dependency 등등 셋팅)
6. Domain Module의 Data Model, UseCase Naming, Network Exception 처리 셋팅
7. Data Module에서 Remote Connection, Local DataBase, Request, Response Model 등등 셋팅 
8. Data Module 의 Remote/Local Data CRUD 테스트 코드 작성 
9. Data Module CRUD 테스트 통과 후 DataSourece(옵션), Domain/Data Module Repository 패턴 구현, Data Mapper 구현
10. Domain Module 의 UseCase, Util, base 등등 구현 구체화
11. AppModule 셋팅 (manifest permission, core-ui, ui base , util,mapper 등등..)
12. AppModule 에서 화면 단 작업 진행 (작업순 ui State Holder,ui State 제작 후 -> Ui)
13. 전체 계층에서 사용할 수 있는 exts, Data Model의 추가가 필요할 시 shared Module 에 추가하여 사용

## 사용할 기술 스펙
- Compose + ViewBinding(XML)
- Flow
- Jatpack ViewModel ,Live Data 
- Room
- DataStore
- Kts gradle
- Paging 3 
- Retrofit + moshi 
- Hilt 
- FireBase 
- Naver Map

## 구성할 아키텍처
_1) Multi Modul_   
1. Data Module: Naver, Daum의 블로그 api로 데이터를 받아 비즈니스 처리 및 Room 으로 캐싱 저장 및 데이터 저장, DataStore로 단편 데이터 저장, 동기작업에 Shared Pref 활용 등등..
2. Domain Module: 순수 Domain에 대한 비즈니스 로직 처리, 여러 데이터 소스의 복잡한 로직을 묶어서 UseCase로 각각의 기능을 SRP을 적용하여 처리함, Repository 를 통해 Dip로 계층을 구분
3. App Module: 프레임워크 관한 상호작용, Ui와 UiStateHolder로 구분하여 효율적으로 이벤트 처리 및 UI상태를 처리함, UDF를 우선적으로 따르며, Flow/LiveData를 이용하여 데이터 스트림을 컨트롤한다.
4. Shared Module : 모든 계층에서 공통적으로 사용할 데이터 형식이나, 전체 모듈에서 사용할 순수 코틀린 exts 등등..
5. 전체: 각 Module에 mapper를 통해 각 계층에 맞는 데이터 형식으로 맵핑하여, 계층을 확실히 구분짓고 domain은 순수의 상태로 사용할 수 있게함 (Shared Modlue은 제외) 

_2) UI 테스트_
1. ViewModel 로직 검증을 우선으로 한다. 
2. ViewModel 테스트 통과후 UI 테스트가 진행된다.

_3) Only Kotlin_
1. xml 보다 Compose를 추구함으로써 Kotlin으로 UI를 관리 한다. 
2. ::과 같은 리플렉션 기능을 통하여 가독성을 높이고 Exts 를 활용하여 재사용성을 높인다.
3. 함수형으로 풀어낼 수 있는 간결함을 응용한다.
4. 전사적으로 불변객체를 선호한다.
5. Sealed class,Data Class, Value Class 등등을 통하여 UI 상태 및 데이터 형식을 효율적으로 관리한다.
6. Kotlin으로 효율적인 추상화 설계를 구축해간다.

_4) Coding Rules Of Android Frame Work_
1. 액티비티 간의 Intent로 소통시 Key는 데이터를 받는 Activity의 상수로 존재한다. 
2. Theme를 변경하면 앱이 전체적으로 색상이 변경되는 유연한 구조를 가져갈 것 
3. 현지화를 생각하여 스트링은 전체적으로 string.xml을 활용할 것 
4. Content Provider, Broad Cast Receiver, Service 등등은 App Module 에서 별도로 잘 관리할 것 
