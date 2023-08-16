# Seoul_Wifi_Service
(23.08.13 ~ 23.08.16)

## skills
- Java 11, Spring boot 2.7.10, gradle
- Thymeleaf, (HTML5, CSS3, javascript)
- MariaDB
- MyBatis
- JUnit 5
- Lombok, gson(json 파싱)
- IntelliJ idea


## 서비스 정보
1. 서울시 공공와이파이 서비스 위치 정보(https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do)에서 제공하는 와이파이 데이터를 이용한다.
2. 브라우저로 부터 내 위치정보를 불러와서, 내 위치에서 가장 가까운 20개의 Wifi 정보를 보여준다.
3. 이외에 위치정보 히스토리, 북마크(즐겨찾기)된 wifi, 북마크 그룹을 저장할 수 있다.
4. 실시간으로 공공 와이파이이 정보를 DB로 load 할 수 있다.


## 상세 기능

### WIFI 불러오기

-  `Open API 와이파이 정보 가져오기` 버튼 클릭 시 서울시에서 제공하는 와이파이 정보를 DB로 load한다.
- 6 ~ 7초 정도 소모

### 근처 WIFI 정보 보기
- 내 위치 위도(lat), 경도(lnt)를 기준으로 가장 가까운 20개의 WIFI 정보를 보여준다.
- 기본은 0.0, 0.0으로 설정되어있고, `내 위치 불러오기` 버튼을 통해 브라우저로부터 내 위치를 불러올 수 있다.
- `내 위치 불러오기` 버튼을 사용하지 않고, 직접 위도 경도값을 입력할 수 있다.

### 와이파이 상세
- 메인 화면에서 와이파이명을 클릭 시 해당 와이파이의 상세 정보를 새로운 창에서 확인할 수 있다.
- `북마크 그룹 선택`으로 북마크 그룹을 선택 후, 해당 와이파이를 북마크로 등록할 수 있다.
- 와이파이 상세에서의 '거리' 항목은 해당 페이지 접근 시의 위치를 기준으로 측정된다.

### 히스토리
- `근처 WIFI 정보보기` 버튼 클릭 시 클릭 시점에 설정된 내 위치 정보가 `위치 히스토리 목록`에 저장된다.
- `위치 히스토리 목록` 버튼 클릭 시 히스토리 목록으로 이동한다.
- `조회` 버튼 클릭 시 해당 히스토리 정보 (위도, 경도)를 기준으로 가장 가까운 20개의 WIFI 정보를 불러온다.
- `삭제` 버튼 클릭 시 해당 히스토리 정보를 삭제한다.

### 북마크 그룹 관리
- 북마크 그룹을 추가, 수정, 삭제할 수 있다.
- '순서' 항목이 작은 순으로 출력된다.
- `북마크 그룹 추가`버튼 클릭 시 (북마크 이름, 순서)를 지정하여 북마크 그룹을 추가할 수 있다.
- `수정` 버튼 클릭 시 북마크 그룹 이름, 순서를 수정할 수 있다.
- `삭제` 버튼 클릭 시 해당 북마크 그룹을 삭제할 수 있다.
    - 북마크 그룹 삭제 시 , 해당 그룹으로 지정된 북마크도 모두 삭제된다.

### 북마크(즐겨찾기)
- WIFI 상세에서 북마크에 추가할 수 있다.
- 북마크는 먼저 추가한 순서대로 출력된다.
- `삭제` 버튼 클릭 시 북마크 정보를 보여주며 삭제 확인 창으로 이동한다.
