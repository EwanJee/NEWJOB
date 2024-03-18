## Projects Descriptions per every class

### AdminController
- (get) /admin : admin 로그인
- (post) /admin : admin 로그인확인
- (get) /admin/list : 모든 consultant 리스트 조회
- (get, post) : /admin/list/{id}/edit : 컨설턴트 정보/진단횟수 수정
- (get) : /admin/list/{id}/delete : 컨설턴트 정보 삭제

### CareerTestController("/consultant")
- (get) /{id}/test/career : 
  - 컨설턴트가 로그인 후, 경력진단 링크를 받을려고 할 때.
  - 어드민에게 인증을 못받은 경우 링크 못 받음
  - 사용 가능한 진단 횟수가 0일 때 링크 못 받음

- (get) /{id}/test/career/start :
  - 컨설턴트로부터 링크를 받은 회원은 진단 테스트 시작.
- (get) /{id}/test/career/location 
- (get) /{id}/test/career/{testId}/second
- (get) /{id}/test/career/{testId}/third
- ...
- (get) /{id}/test/career/{testId}last -> 테스트 끝
- (post) /{id}/test/career/finish/{testId} : pdf 변환 하려했으나 실패.

### ConsultantController("/consultant")
- (get) /admin : 컨설턴트 로그인
- (get) /{id}/welcome : 로그인 후 홈페이지
- (get) /{id}/mypage : 마이페이지 -> 링크받을 수 있음, 고객정보 확인 가능
- (get) /{id}/client : 마이페이지 -> 고객 정보 확인. -> 테스트 링크를 통해 본 고객



