# HooMasJip
- 현재 위치 근처로 블로그 맛집 후기 글을 빠르게 찾아드립니다. 
- 우연히 찾은 맛집 잊지 않도록 저장을 해드립니다.
- 나만의 맛집 지도를 완성할 수 있습니다. 

# 작업 순서 (내림차순 순서)
전체. 전체 계층에서 사용할 수 있는 exts, Data Model의 추가가 필요할 시 shared Module 에 추가하여 사용
1. 후맛집 예상 기획 **[완료]** -> [기획 링크](https://www.figma.com/file/pMXqc6klaWrkOC0aiQ7U4a/%ED%9B%84%EB%A7%9B%EC%A7%91-%EA%B0%84%EB%8B%A8-%EA%B8%B0%ED%9A%8D?node-id=0%3A1)
2. Naver,Daum,Naver Map Api,Sdk 검토 **[완료]** -> [링크](https://www.figma.com/file/xudzmtv5eMUcZTPQtcQs3q/%ED%9B%84%EB%A7%9B%EC%A7%91-API%2CSDK-%EC%A0%95%EB%B3%B4?node-id=0%3A1)
3. 상세 기획 제작 (figma) **[완료]** -> [링크](https://www.figma.com/file/GoFFBFs60dLzAvVv5cL5zO/Untitled?node-id=0%3A1)
4. UI 디자인 제작(스타일 가이드, 재사용 컴포넌트) **진행 대기**
5. 개발 셋팅 (Kts로 변화 , Library Dependency 등등 셋팅)
6. Domain Module의 Data Model, UseCase Naming, Network Exception 처리 셋팅
7. Data Module에서 Remote Connection, Local DataBase, Request, Response Model 등등 셋팅 
8. Data Module 의 Remote/Local Data CRUD 테스트 코드 작성 
9. Data Module CRUD 테스트 통과 후 DataSourece(옵션), Domain/Data Module Repository 패턴 구현, Data Mapper 구현
10. Domain Module 의 UseCase, Util, base 등등 구현 구체화
11. AppModule 셋팅 (manifest permission, core-ui, ui base , util,mapper 등등..)
12. AppModule 에서 화면 단 작업 진행 (작업순 ui State Holder,ui State 제작 후 -> Ui)

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

_5) Link for reference

1. Clean Architeture 설계의 네트워크 예외 처리 방식 토론 
- [Duy Pham의 주장](https://proandroiddev.com/android-error-handling-in-clean-architecture-844a7fc0dc03)
- [Roshaan Farrukh의 주장](https://levelup.gitconnected.com/error-handling-in-clean-architecture-9ff159a25d4a)

2. Ui 상태 관리, 데이터 관리, 이벤트 처리 방식  
 - [Pluu님의 발표 ppt] (https://speakerdeck.com/pluu/kodeu-pumjil-1-percent-olrigi)
 - [윤영직님의 발표 ppt] (https://speakerdeck.com/laco2951/ui-state-modeling-eoddeonge-joheulgga)
 - [김태현님의 발표 ppt] (https://drive.google.com/drive/folders/11_SPawq_FhUTZZSpTsDV_-lwBhGPp5Ar)
 - [박상권 이벤트처리] (https://medium.com/prnd/mvvm%EC%9D%98-viewmodel%EC%97%90%EC%84%9C-%EC%9D%B4%EB%B2%A4%ED%8A%B8%EB%A5%BC-%EC%B2%98%EB%A6%AC%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95-6%EA%B0%80%EC%A7%80-31bb183a88ce)
 - [컴포즈 뷰모델 이벤트 처리 by Saurabh Pant] (https://proandroiddev.com/cleaner-way-to-interact-between-composable-and-viewmodel-in-jetpack-compose-14c8b3a74bbe)
 - [재웅님의 retrofit의 response 모델링] (https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe)

3. Test in android
- [미스터 머글] (https://devvkkid.tistory.com/197)

4. best Pratice
- [헤이딜러 앱 구조 발표 ppt] (https://docs.google.com/presentation/d/18JLMtlQvqWnX7tJPpm4WBAcW0PLvGLQgmaPofpuG2vE/edit#slide=id.g11be1d0e282_0_432)
- [안드로이드 권장 설계] (https://developer.android.com/jetpack/guide?hl=ko)

5. 안드로이드 clean Architeture 의 Use Cases/Interactors 가 필요한 이유
- [Denis Brandi의 정리] https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576

6. flow
- [Alexey Bykov의 요약](https://proandroiddev.com/kotlin-coroutines-flow-in-a-nutshell-90399fc9aed7)

7. Modularization 에 대한 사전 지식
- [Ehsan Ghorbannezhad의 정리] (https://proandroiddev.com/android-modularization-preps-things-to-know-before-modularizing-your-app-deaf795aabec)

8. 과거 아키텍처에 대한 논쟁의 흔적
- [Fernando Cejas의 깃허브 이슈란](https://github.com/android10/Android-CleanArchitecture/issues)
- [Mario Sanoguera de Lorenzo의 좋은 아키텍처란](https://proandroiddev.com/intro-to-app-architecture-922b392b21b2)
- [Mario Sanoguera de Lorenzo의 클린 아키텍처 설명](https://proandroiddev.com/clean-architecture-data-flow-dependency-rule-615ffdd79e29)

9. Jetpack 
- [Jetpack ViewModel의 내부 원리] (https://proandroiddev.com/viewmodel-magic-revealed-330476b5ab27)

10. DDD
- [Android Kagi 번역 - pluu] (https://pluu.github.io/blog/android/droidkaigi/2019/05/01/droidkaigi-ddd/)
- [강남 언니 공식블로그] (https://blog.gangnamunni.com/post/TDDDD_Android/)

11. 기타
- [pluu 부스트 캠프 강의 ppt] (https://speakerdeck.com/pluu/modern-android-developer-annaeseo)
