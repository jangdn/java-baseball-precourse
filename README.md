# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)



## 설계
### story
  * (O) 사용자는 숫자 야구게임을 진행할 수 있다.
    * (O) 컴퓨터는 3개의 랜덤한 수를 뽑아낼 수 있다.
      * (O) 숫자의 범위는 1~9까지이다.
    * (O) 사용자는 3개의 숫자를 입력할 수 있다.
      * (O) 잘못된 값을 입력할 경우 [ERROR] 로 시작하는 메세지를 출력한다.
      * (O) 잘못된 값을 입력할 경우에도 게임을 계속 진행할 수 있다.
    * (O) 사용자는 입력한 수에 따라 힌트를 얻을 수 있다.
      * (O) 같은 자리에 있을 경우 스트라이크를 출력한다.
        * (O) 모든 수가 스트라이크일 경우 게임을 종료한다.
      * (O) 다른 자리에 있을 경우 볼을 출력한다.
      * (O) 같은 수가 전혀 없으면 낫싱을 출력한다.
    * (O) 사용자는 한 게임이 종료된 이후 게임을 다시 시작할 수 있다.
    * (O) 사용자는 한 게임이 종료된 이후 게임을 종료할 수 있다.
### 비기능 사항
  * (O) JDK에서 기본 제공하는 Random, Scanner API 대신 nextstep.utils 패키지에서 제공하는 Randoms, Console API를
      활용해 구현해야한다.
    * (O) Random 값 추출은 nextstep.utils.Randoms의 pickNumberInRange()를 활용한다.
    * (O) 사용자가 입력하는 값은 nextstep.utils.Console의 readLine()을 활용한다.  
  * (O) 프로그램 구현을 완료했을 때 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
  * (O) 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다.
  * (O) 도메인 로직에 단위 테스트를 구현한다.
  * (O) git commit 로그를 https://gist.github.com/stephenparish/9941e89d80e2bc58a153 를 참고해서 남긴다.
  * 리팩토링
    * (O) else 예약어를 쓰지 않는다. 
    * (O) switch문도 사용하지 말아야한다.
    * (O) 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * (O) indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다.
    * (O) 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현
      * 하나의 함수가 하나의 역할을 하는가
### 개인 리팩토링 사항
  * (O) Message 일괄관리
  * (O) 해당 도메인이 담당한 로직이 해당 도메인 것이 맞나?
  * (O) 사용자는 한 게임이 종료된 이후 게임을 다시 시작할 수 있다.
    에서 한 게임에 입력하는 값에 대해서 validation 하므로 다시 시작하는
    로직에서도 validation 하도록 추가 작업
    반복해서 받을 수 있도록
  * 패키징 정리
  * 
  * 테스트 코드 추가