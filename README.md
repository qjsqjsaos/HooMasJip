# HooMasJip
- 현재 위치 근처로 블로그 맛집 후기 글을 빠르게 찾아드립니다. 
- 우연히 찾은 맛집 잊지 않도록 저장을 해드립니다.
- 나만의 맛집 지도를 완성할 수 있습니다. 

# 작업 순서 (내림차순 순서)
전체. 전체 계층에서 사용할 수 있는 exts, Data Model의 추가가 필요할 시 shared Module 에 추가하여 사용
1. 후맛집 예상 기획 **[완료]** -> [기획 링크](https://www.figma.com/file/pMXqc6klaWrkOC0aiQ7U4a/%ED%9B%84%EB%A7%9B%EC%A7%91-%EA%B0%84%EB%8B%A8-%EA%B8%B0%ED%9A%8D?node-id=0%3A1)
2. Naver,Daum,Naver Map Api,Sdk 검토 **[완료]** -> [링크](https://www.figma.com/file/xudzmtv5eMUcZTPQtcQs3q/%ED%9B%84%EB%A7%9B%EC%A7%91-API%2CSDK-%EC%A0%95%EB%B3%B4?node-id=0%3A1)
3. 상세 기획 제작 (figma) **[완료]** -> [링크](https://www.figma.com/file/GoFFBFs60dLzAvVv5cL5zO/Untitled?node-id=0%3A1)
4. gradle 셋팅 (Kts로 변화 , Library Dependency 관리 셋팅) **[완료]**
5. App Architecture 의논 및 프로토타입 제작 **[완료]** 
6. Data 모델링, 필요한 api 목록 구성 -> 진행중 
7. SharedModule 에서 공유할 DataModel 셋팅 
7. DataModule 에서 FireBase,Retrofit2, Request, Response Model, PagingSource, Shared Pref or DataStore 등등 셋팅 
5. Domain Module의 , UseCase Naming, Network Exception 등등 셋팅
7. Data Module 의 Remote/Local Data CRUD 테스트 (유닛 테스트)
8. Data Module CRUD 테스트 통과 후 DataSourece(옵션), Domain/Data Repository 패턴 구현, Mapper 구현(data -> shared)
9. Domain Module 의 UseCase, base 등등 구현 구체화
10. AppModule 셋팅 (manifest permission, core-ui, ui base , util, ui model mapper,base 등등..)
11. AppModule 의 ViewModel data로 프레젠테이션 로직 작업 
12. UI 디자인 완성 (스타일 가이드, 재사용 컴포넌트) **진행 대기**
13. AppModule 의 전체 View 작업 


## 사용할 기술 스펙
- MVVM + Aac DataBinding(XML)
- Flow
- Jatpack ViewModel ,Live Data 
- DataStore ?: Sharedpreferences
- Kts gradle
- Paging 3 
- Retrofit + moshi ?: gson ?: kotlinx.serialization
- Hilt 
- FireBase 
- Naver Map

## 구성할 아키텍처

(의존 방향)   
![화면 캡처 2022-08-10 201657](https://user-images.githubusercontent.com/60532838/183888294-aa4b0211-c60e-4278-9ae0-477181ac1ab2.png)
   
### [전체 아키텍처]

 **1) shared**

→ 모듈간의 의존없이 Data를 교환 할 수 있도록 서브 역활을 합니다.

특이사항: Paiging 3 사용으로 인해 안드로이드 의존성이 생성 되었습니다.  
다른 모듈에게 의존이 전이되지 않도록 주의가 필요합니다.

 **2) data** 

→ 네트워크 통신 및 로컬 네트워크 통신을 책임 지며, 데이터 소스를 생성 및 로직을 처리 합니다.

 **3) domain**

→  전사적인 비즈니스 로직을 책임을 지며, 순수한 기획 의도를 나타냅니다.

 **4) app** 

→ Ui 로직 및 UI, OS와의 소통을 담당하며 mvvm + aac DataBinding 형식으로 만들어집니다.   
   
      
      
### [UI 테스트]
1) ViewModel 로직 검증을 우선으로 한다.    
2) ViewModel 테스트 통과후 UI 테스트가 진행된다.   
   
### [Kotlin 응용]
1) ::과 같은 리플렉션 기능을 통하여 가독성을 높이고 Exts 를 활용하여 재사용성을 높인다.
2) 함수형으로 풀어낼 수 있는 간결함을 응용한다.
3) 전사적으로 불변객체를 선호한다.
4) Sealed class,Data Class, Value Class 등등을 통하여 UI 상태 및 데이터 형식을 효율적으로 관리한다.
5) Kotlin으로 효율적인 추상화 설계를 구축해간다.

### [안드로이드 코드 컨벤션]
1) 액티비티 간의 Intent로 소통시 Key는 데이터를 받는 Activity의 상수로 존재한다. 
2) Theme를 변경하면 앱이 전체적으로 색상이 변경되는 유연한 구조를 가져갈 것 
3) 현지화를 생각하여 스트링은 전체적으로 string.xml을 활용할 것 
4) Content Provider, Broad Cast Receiver, Service 등등은 App Module 에서 별도로 잘 관리할 것 

### [참고할만한 레퍼런스]

1. Clean Architeture 설계의 네트워크 예외 처리 방식 토론 
- [Duy Pham의 주장](https://proandroiddev.com/android-error-handling-in-clean-architecture-844a7fc0dc03)
- [Roshaan Farrukh의 주장](https://levelup.gitconnected.com/error-handling-in-clean-architecture-9ff159a25d4a)

2. Ui 상태 관리, 데이터 관리, 이벤트 처리 방식  
 - [Pluu님의 발표 ppt](https://speakerdeck.com/pluu/kodeu-pumjil-1-percent-olrigi)
 - [윤영직님의 발표 ppt](https://speakerdeck.com/laco2951/ui-state-modeling-eoddeonge-joheulgga)
 - [김태현님의 발표 ppt](https://drive.google.com/drive/folders/11_SPawq_FhUTZZSpTsDV_-lwBhGPp5Ar)
 - [박상권 이벤트처리](https://medium.com/prnd/mvvm%EC%9D%98-viewmodel%EC%97%90%EC%84%9C-%EC%9D%B4%EB%B2%A4%ED%8A%B8%EB%A5%BC-%EC%B2%98%EB%A6%AC%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95-6%EA%B0%80%EC%A7%80-31bb183a88ce)
 - [컴포즈 뷰모델 이벤트 처리 by Saurabh Pant](https://proandroiddev.com/cleaner-way-to-interact-between-composable-and-viewmodel-in-jetpack-compose-14c8b3a74bbe)
 - [컴포즈 UI상태 처리 by Saurabh Pant](https://proandroiddev.com/updating-ui-using-state-management-in-jetpack-compose-e6120db7d695)
 - [재웅님의 retrofit의 response 모델링](https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe)

3. Test in android
- [미스터 머글의 kotest 사용기](https://devvkkid.tistory.com/197)

4. best Pratice
- [헤이딜러 앱 구조 발표 ppt](https://docs.google.com/presentation/d/18JLMtlQvqWnX7tJPpm4WBAcW0PLvGLQgmaPofpuG2vE/edit#slide=id.g11be1d0e282_0_432)
- [안드로이드 공식 권장 설계](https://developer.android.com/jetpack/guide?hl=ko)

5. 안드로이드 clean Architeture 의 Use Cases/Interactors 가 필요한 이유
- [Denis Brandi의 정리](https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576)

6. flow
- [Alexey Bykov의 요약](https://proandroiddev.com/kotlin-coroutines-flow-in-a-nutshell-90399fc9aed7)

7. Modularization 에 대한 사전 지식
- [Ehsan Ghorbannezhad의 정리](https://proandroiddev.com/android-modularization-preps-things-to-know-before-modularizing-your-app-deaf795aabec)

8. 과거 아키텍처에 대한 논쟁의 흔적
- [Martin Fowler 의 3계층](https://martinfowler.com/bliki/PresentationDomainDataLayering.html)
- [Fernando Cejas의 깃허브 이슈란](https://github.com/android10/Android-CleanArchitecture/issues)
- [Mario Sanoguera de Lorenzo의 좋은 아키텍처란](https://proandroiddev.com/intro-to-app-architecture-922b392b21b2)
- [Mario Sanoguera de Lorenzo의 클린 아키텍처 설명](https://proandroiddev.com/clean-architecture-data-flow-dependency-rule-615ffdd79e29)

9. Jetpack 
- [Jetpack ViewModel의 내부 원리](https://proandroiddev.com/viewmodel-magic-revealed-330476b5ab27)
- [Compose effect handlers](https://jorgecastillo.dev/jetpack-compose-effect-handlers)
- [Compose Touch Event Handle](https://proandroiddev.com/jetpack-compose-under-the-hood-touch-events-c237ce1ff755)

10. DDD
- [Android Kagi 번역 DDD - pluu](https://pluu.github.io/blog/android/droidkaigi/2019/05/01/droidkaigi-ddd/)
- [강남 언니 공식블로그 TDDDD](https://blog.gangnamunni.com/post/TDDDD_Android/)

11. 기타
- [pluu 부스트 캠프 강의 ppt - 모던 안드로이드 스킬들](https://speakerdeck.com/pluu/modern-android-developer-annaeseo)
- [마틴파울러 홈페이지](https://www.martinfowler.com/)

