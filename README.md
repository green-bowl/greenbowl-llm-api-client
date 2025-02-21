# ![llm](https://github.com/user-attachments/assets/b66e143c-0f7d-4f09-97a6-04a484767025) Spring  WebFlux 기반 생성형 AI Streaming API Client 템플릿 <img src="https://img.shields.io/badge/v1.1-6DB33F?style=flat-square&logo=Adobe&logoColor=white"><br><br>

## 📋 프로젝트 설명
- LLM Streaming Server를 통해 Spring 기반 서비스에서 LLM 스트리밍 서비스를 제공하는 API 클라이언트 템플릿
- 기본 템플릿과 예시 제공
<br><br>

## 📼 서비스 시연
![hyobin-llm](https://github.com/user-attachments/assets/f62ff497-d639-4176-b21a-e29d6cda76bd)
<br><br>

## 📅 프로젝트 기간
<b>2025. 02. 02</b>
<br><br>

## ![Image](https://github.com/user-attachments/assets/1838d6b9-69ff-43fe-80b1-b1e39709cef9) URL 변경 및 리팩터링
<b>2025. 02. 10</b>
<br><br>

## 👫 구성원

### 성효빈
- 서버 개발, 배포 및 관리
<br>

## 📚 관련 URL
- [서비스 URL](https://hyobin-llm.vercel.app)
- [LLM Streaming 서버 API](https://hyobin-llm.duckdns.org/docs)
- [LLM Spring API 클라이언트 서버 API](https://hyobin-llm-spring.duckdns.org/swagger-ui/index.html)
- [LLM Nest.js API 클라이언트 서버 API](https://hyobin-llm-nest.duckdns.org/api)
- [LLM 클라이언트 Repository](https://github.com/hellmir/LLM-Streaming-Client)
- [LLM Streaming 서버 Repository](https://github.com/hellmir/LLM-Streaming-Server)
- [LLM Nest API 클라이언트 서버 Repository](https://github.com/hellmir/LLM-Nest-API-Client)
  <br><br>

## ![ai](https://github.com/user-attachments/assets/d2cdfacc-c141-400c-9ba4-3f77d7664714) LLM Models
- Mistral Large
- HCX-003
- Gemini 1.5 Pro
- Llama 3.3
- GPT 4o Mini
- Claude Haiku
- DeepSeek V3

## 🗼 Architecture
![llm-service](https://github.com/user-attachments/assets/e12f5131-d55a-4142-bae1-f58b40b91784)

## 🛠️ Skills

## Back-End
- Java 11
- Spring Boot
- Spring WebFlux
- Spring Security
  <br>

## DevOps

### Build
- Gradle

### WAS
- Tomcat

### Server
- AWS EC2
  <br>

## Tools

### IDE
- IntelliJ

### Issue Tracking
- Jira

<br>

## 릴리스 정보 - LLM Streaming API Client - LlmStreamingApiClientRelease02/02

### 하위 작업

[LSAC-3](https://langchain.atlassian.net/browse/LSAC-3) gradle 의존성 추가

[LSAC-4](https://langchain.atlassian.net/browse/LSAC-4) production application 설정 추가

[LSAC-5](https://langchain.atlassian.net/browse/LSAC-5) production application 클래스 추가

[LSAC-6](https://langchain.atlassian.net/browse/LSAC-6) gitignore 추가

[LSAC-8](https://langchain.atlassian.net/browse/LSAC-8) 로깅 설정 파일 추가

[LSAC-9](https://langchain.atlassian.net/browse/LSAC-9) LoggingInterceptor 추가

[LSAC-10](https://langchain.atlassian.net/browse/LSAC-10) LoggingAspect 추가

[LSAC-12](https://langchain.atlassian.net/browse/LSAC-12) 인증을 위한 필터 설정

[LSAC-13](https://langchain.atlassian.net/browse/LSAC-13) JWT 토큰 설정

[LSAC-14](https://langchain.atlassian.net/browse/LSAC-14) 인증 없이 요청 가능한 엔드포인트 허용 설정

[LSAC-15](https://langchain.atlassian.net/browse/LSAC-15) 특정 출처에 대한 CORS 활성화

[LSAC-17](https://langchain.atlassian.net/browse/LSAC-17) springfox 의존성 추가

[LSAC-18](https://langchain.atlassian.net/browse/LSAC-18) Swagger 설정 추가

[LSAC-20](https://langchain.atlassian.net/browse/LSAC-20) 기존에 구현한 LLM Streaming 서버로 Prompt 요청을 전송해 응답을 제공받는 클라이언트 컴포넌트 추가

[LSAC-21](https://langchain.atlassian.net/browse/LSAC-21) 특정 Prompt에 대한 Steraming 응답을 제공받을 수 있는 템플릿 엔드포인트 추가

[LSAC-22](https://langchain.atlassian.net/browse/LSAC-22) 특정 Prompt에 대한 SSE 방식의 Steraming 응답을 제공받을 수 있는 템플릿 엔드포인트 추가

[LSAC-23](https://langchain.atlassian.net/browse/LSAC-23) 레시피 추천 요청 Prompt에 대한 Steraming 응답을 제공받을 수 있는 예시 엔드포인트 추가

[LSAC-24](https://langchain.atlassian.net/browse/LSAC-24) 레시피 추천 요청 Prompt에 대한 SSE 방식의 Steraming 응답을 제공받을 수 있는 레시피 추천 예시 엔드포인트 추가

### 에픽

[LSAC-1](https://langchain.atlassian.net/browse/LSAC-1) LLM API 클라이언트 서버 템플릿 구현

### 스토리

[LSAC-19](https://langchain.atlassian.net/browse/LSAC-19) 클라이언트는 서버로부터 개발 서비스 도메인에 대한 LLM 스트리밍 서비스를 제공받을 수 있다

### 작업

[LSAC-2](https://langchain.atlassian.net/browse/LSAC-2) 프로젝트 환경 설정

[LSAC-7](https://langchain.atlassian.net/browse/LSAC-7) 전체 프로젝트의 로깅 프로세스 추가

[LSAC-11](https://langchain.atlassian.net/browse/LSAC-11) Spring Security 설정 추가

[LSAC-16](https://langchain.atlassian.net/browse/LSAC-16) 서버 API 문서화를 위한 Swagger 추가

[LSAC-25](https://langchain.atlassian.net/browse/LSAC-25) README.md 추가
<br><br>

## 릴리스 정보 - LLM Spring API Client - LlmSpringApiClientRelease02/10

### 하위 작업

[LSAC-30](https://langchain.atlassian.net/browse/LSAC-30) 일부 클래스의 마지막에 밑줄 추가

[LSAC-31](https://langchain.atlassian.net/browse/LSAC-31) 서버 URL 변경

[LSAC-32](https://langchain.atlassian.net/browse/LSAC-32) 일반 Streaming 응답과 SSE 응답 메서드의 중복을 제거하고 SSE 여부의 파라미터를 받도록 변경

### 작업

[LSAC-25](https://langchain.atlassian.net/browse/LSAC-25) README.md 추가

[LSAC-29](https://langchain.atlassian.net/browse/LSAC-29) 전반적인 리팩터링
