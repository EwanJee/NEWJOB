# 커리어 진단 프로젝트

이 웹사이트는 커리어 컨설턴트 (카운슬러)를 대상으로 만들었습니다. 
컨설턴트에게 경력/퇴직 진단 링크가 주어집니다. 
컨설턴트는 고객들에게 링크를 보내 진단 테스트를 받게하고, 웹 사이트내에서 진단 결과를 확인하게 해주는 서비스입니다.

# Tech:
Spring MVC, Spring JPA, JDBC Thymeleaf, lombok, MariaDB

# Plans:
Spring MVC를 이용한 레이어드 아키텍처를 구현하였습니다.

# JPA - MariaDB
객체는 다음과 같이 구성되어 있습니다.
1. 컨설턴트
2. 커리어진단결과
3. 퇴직진단결과

컨설턴트 1 - N 커리어진단결과 (일대다 관계)
컨설턴트 1 - N 퇴직진단결과 (일대다 관계)

# Thymeleaf를 사용한 이유
1. 프론트엔트 프레임워크를 잘 몰라서
2. DB에 있는 질문을 가져와서 웹에 띄워야 하고, 진단결과 각 항목에 맞는 점수도 웹에 띄워야 한다. 이에 관해서는 CSR보다는 SSR이 맞다고 생각이 들어 타임리프를 적용했습니다.

# 아쉬운점

1.진단서비스를 할때 80문항이 있으면 10문항이 끊어서 해야하는 경우, 첫 10문항을 마치면 다음 문항 div를 보이게 하고 전 10문항들은 div 숨김을 하는 방법이 있었는데 서툴러서 10문항 완료 후 다음 페이지로 넘어가서 다음 10문항을 보여주는 방식을 택했습니다. 이를 고치고 싶은데 방법을 못찾았습니다.

2. JPA로 쓸 수 있는 방법이 있을텐데, 방법을 찾지못해 JDBC를 사용했습니다.

