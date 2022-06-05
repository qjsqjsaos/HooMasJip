# HooMasJip
- 현재 위치 근처로 블로그 후기 맛집 포스팅들을 빠르게 찾아드립니다. 네이버 + 다음 등등 검색엔진을 활용하여 원하는 정보를 클릭 한번으로 얻어가실 수 있으리라 기대됩니다.


## 사용할 기술 스펙
- Compose + ViewBinding(XML)
- Flow
- Jatpack ViewModel 
- Room
- DataStore
- Kts gradle
- Paging 3 
- Retrofit + moshi 

## 구성할 아키텍처
_1) Multi Modul_   
1. Data Module: Naver, Daum의 블로그 api로 데이터를 받아 비즈니스 처리 및 Room 으로 캐싱 저장 및 데이터 저장, DataStore로 단편 데이터 저장, 동기작업에 Shared Pref 활용 등등..
2. Domain Module: 순수 Domain에 대한 비즈니스 로직 처리, 여러 데이터 소스의 복잡한 로직을 묶어서 UseCase로 각각의 기능을 SRP을 적용하여 처리함, Repository 를 통해 Dip로 계층을 구분
3. App Module: 프레임워크 관한 상호작용, Ui와 UiStateHolder로 구분하여 효율적으로 이벤트 처리 및 UI상태를 처리함 
4. 전체: 각각 Module에 mapper를 두어서 각 계층에 맞는 데이터 형식으로 맵핑하여, 계층을 확실히 구분짓고 domain은 순수의 상태로 사용할 수 있게함 
5. Shared Module : 모든 계층에서 공통적으로 사용할 데이터 형식이나, 전체 모듈에서 사용할 순수 코틀린 exts 등등..

_2) UI 테스트_
1. ViewModel 로직 검증을 우선으로 한다. 
2. ViewModel 테스트 통과후 UI 테스트가 진행된다.

_3) Only Kotlin_
1. xml 보다 Compose를 추구함으로써 Kotlin으로 UI를 관리 한다. 
2. ::과 같은 리플렉션 기능을 통하여 가독성을 높이고 Exts 를 활용하여 재사용성을 높인다.
3. 함수형으로 풀어낼 수 있는 간결함을 응용한다.
4. 전사적으로 불변객체를 선호한다.
5. Sealed class,Data Class, Value Class 등등을 통하여 UI 상태 및 데이터 형식을 효율적으로 관리한다.
6. Kotlin으로 효율적인 추상화 설계를 최대한 만들어간다.

_4) Coding Rules Of Android Frame Work_
1. 액티비티 간의 Intent로 소통시 Key는 데이터를 받는 Activity의 상수로 존재한다. 
2. Theme를 변경하면 앱이 전체적으로 색상이 변경되는 유연한 구조를 가져갈 것 
3. 현지화를 생각하여 스트링은 전체적으로 string.xml을 활용할 것 
4. Content Provider, Broad Cast Receiver, Service 등등은 App Module 에서 별도로 잘 관리할 것 
