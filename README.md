# 스프링 핵심 원리 - 기본편
- 스프링을 이해하는 것은 객체 지향 설계를 이해하는 것

## 섹션1 객체 지향 설계와 스프링
### 자바 진영의 추운 겨울과 스프링의 탄생 
- 스프링 역사 
  - 2002 로드 존슨

### 스프링이란?
- 스프링 생태계 
  - 필수: 스프링 프레임워크, 스프링 부트
  - 선택: 데이터, 세션, 시큐리티, Rest docs, 배치, 클라우드
  - 외에도 굉장히 많은 기술이 있다. 
- 스프링 프레임워크
  - 핵심 기술: 스프링 DI 컨테이너, AOP, 이벤트, 기타
  - 웹 기술: 스프링 MVC, 스프링 WebFlux
  - 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML 지원
  - 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
  - 테스트: 스프링 기반 테스트 지원
  - 언어: 코틀린, 그루비
- 스프링 부트
  - 스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용
  - 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
    - Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
    - 손쉬운 빌드 구성을 위한 starter 종속성 제공
    - 스프링 3rd party 라이브러리 자동 구성
    - 메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공
    - 관례에 의한 간결한 설정
- 스프링이라는 단어?
  - 스프링이라는 단어는 문맥에 따라 다르게 사용된다.
  - 스프링 DI 컨테이너 기술
  - 스프링 프레임워크
  - 스프링 부트, 프레임워크를 모두 포함한 생태계
  
- 핵심 개념 : 이 기술을 왜 만들었는가?
  - 스프링은 자바 언어 기반의 프레임 워크
  - 자바의 가장 큰 특징 - 객체 지향 언어 
  - **스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있도록 도와주는 프레임워크**

> 핵심 컨셉을 제대로 이해하고 사용해야 내 것이 된다.

### 좋은 객체 지향 프로그래밍이란?
- 유연하고 변경 용이함 : 다형성
- 다형성의 실세계 비유
  - 역할과 구현으로 세상을 구분
  - ex. 운전자 - 자동차 
    - 자동차 인터페이스를 기준으로 K3, 아반떼, 테슬라 등등으로 자동차를 구현함
    - 클라이언트에 영향을 주지 않고 새로운 구현이 가능하다. 
  - ex. 공연에서 로미오와 줄리엣
    - 로미오, 줄리엣 역할을 어떤 배우가 하던 상관 없다.

- 역할과 구현을 분리
  - 역할과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.
  - 장점
    - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
    - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
    - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
    - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
- 자바
  - 자바 언어의 다형성을 활용
  - 객체를 설계할 때 역할과 구현을 분리 
- 객체의 협력이라는 관계부터 생각
  - 혼자 있는 객체는 없다.
  - 클라이언트: 요청, 서버: 응답
  - 수 많은 객체 클라이언트와 객체 서버는 요청과 응답을 주고 받는다. 
- 인터페이스를 잘 설계하는 것이 중요하다.
- 스프링과 객체 지향
  - 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
  - 스프링에서 이야기하는 IoC, DI는 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.

### 좋은 객체 지향 설계의 5가지 원칙(SOLID)
- 로버트 마틴이 정리
- 단일 책임 원칙 Single Responsibility Principle
  - 한 클래스는 하나의 책임만 가져야 한다.
- 개방-폐쇄 원칙 Open-Closed Principle
  - 소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀있어야 한다.
  - 객체를 생성하고 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다. - DI container
- 리스코프 치환 원칙 Liskov Substitution Principle
  - 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 인터페이스 분리 원칙 Interface Segregatioon Principal
  - 특정 클라이언트를 위한 인터페이스가 범용 인터페이스 보다 낫다.
- 의존관계 역전 원칙 Dependency Inversion Principle
  - 구현 클래스에 의존하지 말고 인터페이스에 의존하라는 뜻
- 객체 지향의 핵심은 다형성
  - 다형성 만으로는 OCP, DIP를 지킬 수 없다.

### 객체 지향 설계와 스프링
- 스프링은 DI로 다형성 + OCP, DIP를 가능하게 지원 
- 인터페이스를 도입하면 추상화라는 비용이 발생한다.
  - 구체 클래스만 봐서는 어떤 구현체를 사용한지 알 수 없다. 
- 기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용하고, 향후 꼭 필요할 때 리팩토링을 해서 인터페이스를 도입하는 것도 방법





























