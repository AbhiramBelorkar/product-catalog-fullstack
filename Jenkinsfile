pipeline {
    agent any

    environment {
        BACKEND_DIR = 'product.catalog'
        FRONTEND_DIR = 'product-catalog-react'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AbhiramBelorkar/product-catalog-fullstack.git'
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
                bat "cp -r ${FRONTEND_DIR}/build/* ${BACKEND_DIR}/src/main/resources/static/"
            }
        }

        stage('Build Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                    bat './mvnw clean package'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying product-catalog-fullstack'
            }
        }
    }
}
