## [Auth]
 **1. 구글 로그인 Sdk 연동 (자동로그인 셋팅)**   
 **2. 카카오톡 로그인 Sdk 연동 (자동로그인 셋팅)**

-> 두개다 로그인 인증 id를 가져옴
  -> 로컬에 로그인된 id 저장 


## [맛집]
 **1. 맛집 목록 조회 api**   
    - request = 사용자.id   
    - response = 맛집 목록   
 **2. 맛집 상세 조회 api**   
    - request = 맛집.id   
    - response = 맛집    
 **3. 맛집 검색 api**    
    - request = 검색명(String)   
    - response = 검색 된 맛집 목록   
 **4. 맛집 추가 api**   
    - request = body (맛집 정보 + 사용자.id)   
    - response = 추가 성공 여부   
 **5. 맛집 수정 api**    
    - request = body (맛집 정보 + 사용자.id)   
    - response = 수정 성공 여부   
 **6. 맛집 삭제 api**    
    - request = 맛집.id, 사용자.id   
    - response = 삭제 성공 여부   


## [후기 (블로그 링크)]
  **1. 네이버 블로그 목록 조회 api**   
      - request = 사용자 주소(좌표로 변환한) + 주변 맛집을 query명으로 검색   
      - response = 네이버 블로그 데이터   
  **2. 다음 블로그 목록 조회 api**   
      - request = 사용자 주소(좌표로 변환한) + 주변 맛집을 query명으로 검색   
      - response = 다음 블로그 데이터   
  **3. 후기 목록 조회 api**
      - request = 사용자.id   
      - response = 네이버 블로그 데이터   
  **4. 후기 찜 등록 api**    
      - request = 사용자.id, 블로그 Url    
      - response = 후기 찜 등록 성공 여부    
  **5. 후기 찜 취소 api**
      - request = 사용자.id, 블로그 Url    
      - response = 후기 찜 등록 취소 여부    
  **6. 후기 목록 아이템 위치변경 api** 
      - request = 사용자 id, 이전 포지션, 새로운 포지션   
      - response = 위치 변경 성공 여부    
## [위치]
 **1. 지오코드 (좌표 -> 주소 변환) api**     
      - request = 좌표   
      - response = 주소 명   
 **2. 네이버 지도 sdk 사용**    
