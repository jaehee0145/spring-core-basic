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

## 섹션2 스프링 핵심 원리 이해1 - 예제 만들기 
### 프로젝트 생성
### 비즈니스 요구사항과 설계
### 회원 도메인 설계
### 회원 도메인 개발
### 회원 도메인 실행과 테스트 
### 주문과 할인 도메인 설계
### 주문과 할인 도메인 개발

## 섹션3 스프링 핵심 원리 이해2 - 객체 지향 원리 적용

### 관심사의 분리 
- 객체의 생성과 연결은 `AppConfig`가 담당한다.
- DIP 완성 : `MemberServiceImpl`은 `MemberRepository`인 추상에만 의존한다. 이제 구체 클래스를 몰라도 된다.
- 관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리되었다.

### AppConfig 리팩터링
- 애플리케이션 전체 구성이 어떻게 되었는지 `AppConfig`를 통해 확인 가능
- 중복 제거 

### 좋은 객체 지향 설계의 5가지 원칙의 적용
- SRP 단일 책임 원칙 : 한 클래스는 하나의 책임만 갖는다.
  - AS IS : 클라이언트 객체가 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음
  - TO BE : 구현 객체를 생성하고 연결하는 책임은 AppConfig, 클라이언트 객체는 실행하는 책임만 담당
- DIP 의존관계 역전 원칙 : 구체화가 아니라 추상화에 의존한다.
  - AS IS : 클라이언트 객체가 추상화 인터페이스에 의존하는 것처럼 보였지만 구체화 구현 클래스에도 함께 의존
  - TO BE : 클라이언트 객체에는 추상화 인터페이스만 남기고 구현 클래스는 AppConfig에서 생성, 연결함
- OCP 개방 폐쇄 원칙 : 확장에는 열려있고 변경에는 닫혀있다.
  - AS IS : 구체화 클래스를 변경하려면 클라이언트 코드를 변경해야 함
  - TO BE : AppConfig만 변경하면 클라이언트 코드 변경 없이 확장 가능

### 스프링으로 전환하기 
- AppConfig를 스프링 기반으로 변경
  - `AppConfig`에 설정을 구성한다는 뜻의 `@Configuration`을 붙여준다.
  - 각 메서드에 `@Bean`을 붙이면 스프링 컨테이너에 스프링 빈으로 등록된다.
- 스프링 컨테이너
  - ApplicationContext를 스프링 컨테이너라고 한다.
  - AS IS : 개발자가 AppConfig를 사용해서 직접 객체를 생성하고 주입
  - TO BE 
    - 스프링 컨테이너가 @Configuration이 붙은 AppConfig를 구성 정보로 사용한다.
    - 여기서 @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 스프링 빈으로 등록한다.
    - 스프링 빈은 @Bean이 붙은 메서드 명을 스프링 빈의 이름으로 사용한다.
    - applicationContext.getBean()을 사용해서 스프링 빈을 사용할 수 있다.


## 섹션4 스프링 컨테이너와 스프링 빈
### 스프링 컨테이너 생성
- `ApplicationContext`를 스프링 컨테이너라고 한다. 
- `ApplicationContext`는 인터페이스

1. 스프링 컨테이너 생성 
   - AppConfig.class로 구성정보를 전달해서 `new AnnotationConfigApplicationContext(AppConfig.class)` 스프링 컨테이너 생성
   - 스프링 컨테이너 내부에는 스프링 빈 저장소가 있다.
2. 스프링 빈 등록 
   - `@Bean` 메서드 이름을 빈 이름으로 한 객체를 생성해서 스프링 빈 저장소에 저장한다.
3. 스프링 빈 의존관계 설정 - 준비
4. 스프링 빈 의존관계 설정 - 완료
   - 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입한다.

### 컨테이너에 등록된 모든 빈 조회
> iter + tab : for문 생성 단축키

### 스프링 빈 조회 - 기본
### 스프링 빈 조회 - 동일한 타입이 둘 이상
### 스프링 빈 조회 - 상속 관계
- 부모 타입으로 조회하면 자식 타입도 함께 조회된다.
  - 최상위 객체인 Object 타입으로 조회하면 모든 스프링 빈이 조회된다.

### BeanFactory와 ApplicationContext
- BeanFactory
  - 스프링 컨테이너의 최상위 인터페이스
  - 스프링 빈을 관리하고 조회하는 역할

- ApplicationContext
  - BeanFactory 기능을 모두 상속 받아서 제공한다

- ApplicationContext가 추가로 제공하는 부가기능
  - MessageSource : 국제화
  - EnvironmentCapable : 환경변수
  - ApplicationEventPublisher : 이벤트
  - ResourceLoader : 파일, 클래스패스 등 리소스 

- ApplicationContext는 BeanFactory의 모든 기능을 상속받는다.
- 추가로 제공하는 부가기능이 있다.
- BeanFactory를 직접 사용할 일은 거의 없다. 
- ApplicationContext, BeanFactory를 스프링 컨테이너라고 한다. 

### 다양한 설정 형식 지원 - 자바코드, XML

### 스프링 빈 설정 메타 정보 - BeanDefinition
- 스프링이 다양한 설정 형식을 지원할 수 있는 이유 
- 스프링 컨테이너는 메타 정보를 기반으로 스프링 빈을 생성한다.
  - `@Bean` , `<bean>` 당 각각 하나씩 메타 정보가 생성된다.
  - 자바코드인지, XML인지는 상관없다.

## 섹션5 싱글톤 컨테이너
### 웹 애플리케이션과 싱글톤
- 스프링은 엔터프라이즈 애플리케이션을 위해 탄생 
- 대부분의 스프링 애플리케이션은 웹 애플리케이션
- 웹 애플리케이션은 보통 동시에 여러 요청을 받는다.
- 요청을 받을때마다 객체가 생성되면???? 비효율 + 메모리 낭비

### 싱글톤 패턴
- 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
- 싱글톤 패턴을 적용하면 이미 만들어진 객체를 공유해서 효율적으로 사용할 수 있다.
- 하지만 수많은 문제점
  - 코드양이 많다.
  - 테스트가 어렵다.
  - 내부 속성을 변경하거나 초기화 하기 어렵다.
  - 유연성이 떨어진다.

### 싱글톤 컨테이너
- 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서 객체 인스턴스를 싱글톤으로 관리한다.
- 스프링 컨테이너는 싱글톤 컨테이너의 역할을 한다.
- 싱글턴 패턴의 문제
  - 지저분한 코드
  - DIP, OCP, 테스트, private 생성자로부터 자유롭게 

### 싱글톤 방식의 주의점
- 여러 클라이언트가 하나의 객체 인스턴스를 공유하기 때문에 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다.
- 스프링 빈은 무상태(stateless)로 설계해야 한다.

### @Configuration과 싱글톤
### @Configuration과 바이트코드 조작의 마법
- @Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 반환, 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어진다.
- 싱글톤이 보장되는 이유
  - CGLIB 라이브러리
- @Bean만 사용해도 스프링 빈으로 등록되지만 싱글톤이 보장되지는 않는다. 
  - 스프링 설정 정보는 @Configuration을 사용하자.


## 섹션6 컴포넌트 스캔
### 컴포넌트 스캔과 의존관계 자동 주입 시작하기
- @ComponentScan
  - @Component 애노테이션이 붙은 클래스를 빈으로 등록한다.
  - @Autowired 생성자에 붙이면 자동으로 의존관계 주입 

### 탐색 위치와 기본 스캔 대상
- 설정 정보 클래스를 프로젝트 최상단에 두는 것이 좋다. 
- @SpringBootApplication 에 @ComponentScan이 포함되어 있음
- @Component이 포함된 어노테이션
  - @Controller, @Service, @Repository, @Configuration 

> 애노테이션에는 상속관계라는 개념이 없다. 특정 애노테이션이 포함되어 있다는 것은 스프링이 지원하는 기능

### 필터
- @ComponentScan 옵션 
  - includeFilters, excludeFilters

### 중복 등록과 충돌 
- 스프링 부트에서는 수동 빈 vs 자동 빈 충돌하는 경우에 오류가 발생하도록 기본 값이 설정되어 있음
  - spring.main.allow-bean-definition-overriding=true


## 섹션7 의존관계 자동 주입
### 다양한 의존관계 주입 방법
- 의존관계 주입 4가지 방법
  - 생성자 주입
  - 수정자 주입 (setter)
  - 필드 주입
  - 일반 메서드 주입

- 생성자 주입
  - 생성자 호출 시점에 딱 1번만 호출되는 것이 보장된다.
  - 불편, 필수 의존관계에 사용 
  - 생성자가 1개만 있으면 @Autowired 생략 가능 

- 수정자 주입 (setter)
  - 선택, 변경 가능성이 있는 의존관계에 사용
  - 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법

- 필드 주입
  - 외부에서 변경이 불가능해서 테스트 할 수 있는 방법이 없다. 
  - DI 프레임워크가 없으면 아무것도 할 수 없다.
  - 되도록 사용하지 말자! 

- 일반 메서드 주입
  - 일반적으로 잘 사용하지 않는다. 
  
### 옵션 처리 
- 주입할 스프링 빈이 없어도 동작해야 할 때
  - @Autowired(required = false)
  - @Nullable
  - Optional

### 생성자 주입을 선택해라!
- 최근에는 스프링을 포함한 DI 프레임워크 대부분이 생성자 주입을 권장한다. 
- 불변
  - 대부분 의존관계 주입은 한번 일어나면 애플리케이션 종료 시점까지 의존관계를 변경할 일이 없다. 
  - 수정자 주입을 사용하면 setter를 public으로 열어둬야 한다.
  - 생성자 주입을 사용하면 객체를 생성할 때 딱 1번만 호출되므로 불변하게 설계할 수 있다. 
- 누락
  - 프레임워크 없이 순수하게 자바 코드를 단위 테스트 하는 경우에 
    - 생성자 주입을 사용하면 컴파일 오류로 의존관계 주입이 누락된 것을 파악할 수 있다.
- final 키워드
  - 생성자 주입을 사용하면 필드에 final 키워드를 사용할 수 있다. 
    - 생성자에서 값이 설정되지 않는 경우 컴파일 오류 발생

### 롬복과 최신 트렌드 
- build.gradle에 설정 추가
- @RequiredArgsConstructor : final이 붙은 필드에 대한 생성자를 만들어줌
  - 의존관계 추가할 때 간편

### 조회 빈이 2개 이상 - 문제
### @Autowired 필드명, @Qualifier, @Primary
- @Autowired 필드명
  - 타입 매칭을 시도 -> 결과가 2개 이상이면 필드 이름, 파라마터 이름으로 추가 매칭 
- @Qualifier
  - 스프링 빈 등록할때, 주입할때 애노테이션을 붙인다. 
- @Primary
  - 애노테이션을 붙인 빈이 우선권을 갖는다.
  
### 애노테이션 직접 만들기
- @Qualifier("exampleBean")
  - string으로 설정하기 때문에 컴파일시 타입 체크가 안된다.
  - 애노테이션을 직접 만들어서 해결 가능

### 조회한 빈이 모두 필요할때 List, Map
- 동적으로 빈을 선택해야 하는 경우 collection으로 받아서 선택, 사용

### 자동, 수동의 올바른 실무 운영 기준 
- 편리한 자동 기능을 기본으로 사용하자 
  - 스프링부트는 컴포넌트 스캔을 기본으로 사용
  - 자동 빈 등록을 사용해도 OCP, DIP를 지킬 수 있다!
- 수동 빈 등록은 언제 사용하면 좋을까? 
  - 설정 정보로 한꺼번에 보는 경우가 좋을 때
  - 비즈니스 로직 중에서 다형성을 적극 활용할 때

## 섹션8 빈 생명주기 콜백 
### 빈 생명주기 콜백 시작 
- 스프링 빈은 간단하게 다음과 같은 라이프 사이클을 가진다. (생성자 주입 예외)
  - 객체 생성 -> 의존관계 주입 
- 스프링 빈의 이벤트 라이프 사이클
  - 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸 전 콜백 -> 스프링 종료 
- 초기화 콜백: 빈이 생성되고 빈의 의존관계 주입이 완료된 후 호출
- 소멸 전 콜백 : 빈이 소멸되기 직전에 호출 

> 참고 "객체의 생성과 초기화를 분리하자"
> 객체 생성 : 필수 정보를 받고 메모리를 할당해서 객체를 생성 
> 초기화 : 외부 커넥션을 연결하는 등 무거운 동작
> 생성자 안에서 무거운 동작을 하는 것보다는 분리하는 것이 유지보수 차원에서 좋다.

- 스프링은 크게 3가지 방법을 제공한다. 

### 인터페이스 InitializingBean, DisposableBean
- 스프링 전용 인터페이스라서 코드가 스프링 전용 인터페이스에 의존하게 된다.
- 초기화, 소멸 메서드의 이름을 변경할 수 없다. 
- 코드 수정이 안되는 외부 라이브러리에 적용할 수 없다. 
- 인터페이스를 사용하는 방법은 초창기에 나온 방법들이라 지금은 거의 사용하지 않는다.

### 빈 등록 초기화, 소멸 메서드
- 메서드 이름을 자유롭게 사용 가능
- 스프링 빈이 스프링 코드에 의존하지 않는다.
- 코드가 아니라 설정 정보를 사용하기 때문에 외부 라이브러리에도 적용할 수 있다.
- 종료 메서드 추론
  - @Bean의 destroyMethod는 기본값이 추론 inferred 로 등록되어 있어서 close, shutdown 이라는 이름의 메서드를 자동으로 호출해준다.

### 애노테이션 @PostConstruct, @PreDestroy
- 스프링에서 권장하는 방법
- 애노테이션만 붙이면 되니까 편리함
- 스프링에 종속적인 기술이 아니라 자바 표준
- 단점은 외부 라이브러리에 적용하지 못함































