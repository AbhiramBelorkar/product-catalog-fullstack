pipeline {
    agent any

    environment {
        BACKEND_DIR = 'product-catalog'
        FRONTEND_DIR = 'product-catalog-react'
    }

    stages {
        stage('Checkout') {
            steps {
                git(
                    url: 'https://github.com/AbhiramBelorkar/product-catalog-fullstack.git',
                    branch: 'main'
                )
            }
        }

        stage('Build Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('Copy Frontend to Backend') {
            steps {
                // On Windows, use 'xcopy' or 'robocopy' instead of 'cp'
                bat "xcopy /E /I /H /Y ${FRONTEND_DIR}\\build\\* ${BACKEND_DIR}\\src\\main\\resources\\static\\"
            }
        }

        stage('Build Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    bat '.\\mvnw clean package' // Use .\\mvnw to run Maven Wrapper on Windows
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Starting Spring Boot application...'
                bat 'java -jar target\\*.jar'
            }
        }
    }
}
