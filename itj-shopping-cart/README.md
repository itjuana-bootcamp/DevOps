# ITJ Shopping Cart API

A simple, containerized Spring Boot shopping cart application with a REST API and a client-side JavaScript UI.

## Technologies

-   **Java 21**: Core language.
-   **Spring Boot 3.5.5**: Application framework.
-   **Maven**: Build tool.
-   **Docker**: Containerization.
-   **Thymeleaf & JavaScript**: Frontend rendering.

## Prerequisites

-   Java 21 Development Kit (JDK)
-   Maven (or use the included `mvnw` wrapper)
-   Docker (optional, for containerization)

## How to Setup

1.  **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd itj-shopping-cart
    ```

2.  **Build the project**:
    ```bash
    ./mvnw clean install
    ```

## How to Run

### Local (Dev)

Run the Spring Boot application directly:

```bash
./mvnw spring-boot:run
```

The application will start at `http://localhost:8080`.

### Docker

Build and run using Docker Compose:

```bash
# Build and start container in detached mode
docker-compose up -d --build

# Stop the container
docker-compose down
```

The application will be available at `http://localhost:8080`.

## How to Run Tests

Execute unit and integration tests using Maven:

```bash
./mvnw test
```

## CI/CD Integration

To integrate with a CI/CD pipeline (e.g., GitHub Actions), create a workflow file `.github/workflows/ci-cd.yml`. This example builds the Java application, runs tests, and builds the Docker image.

```yaml
name: Java CI with Maven and Docker

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build-and-test:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: maven
        
    - name: Build with Maven
      run: ./mvnw -B package --file pom.xml

    - name: Run Tests
      # Maven test phase runs unit and integration tests automatically
      run: ./mvnw test

    - name: Build Docker Image
      run: docker build . --file Dockerfile --tag itj-shopping-cart:latest

    # Optional: Log in and Push to Docker Hub
    # - name: Login to Docker Hub
    #   uses: docker/login-action@v2
    #   with:
    #     username: ${{ secrets.DOCKERHUB_USERNAME }}
    #     password: ${{ secrets.DOCKERHUB_TOKEN }}
    #
    # - name: Push Docker Image
    #   run: |
    #     docker tag itj-shopping-cart:latest ${{ secrets.DOCKERHUB_USERNAME }}/itj-shopping-cart:latest
    #     docker push ${{ secrets.DOCKERHUB_USERNAME }}/itj-shopping-cart:latest
```
