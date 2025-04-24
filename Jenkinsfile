pipeline {
    agent any

    environment {
        BACKEND_DIR = 'product-catalog'
        FRONTEND_DIR = 'product-catalog-react'
        DOCKER_COMPOSE_CMD = 'docker-compose up --build --force-recreate'
        NPM_GLOBAL_PATH = "$HOME/.npm-global/bin"
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs() // Cleans up the workspace more gracefully
            }
        }

        stage('Checkout') {
            steps {
                git(
                    url: 'https://github.com/AbhiramBelorkar/product-catalog-fullstack.git',
                    branch: 'main'
                )
            }
        }

        stage('Verify NPM') {
            steps {
                sh 'npm -v || echo "npm not found"'
                sh 'node -v || echo "node not found"'
            }
        }

        // Run backend and frontend build in parallel to save time

        stage('Build') {
            parallel {
                stage('Build Backend') {
                    steps {
                        dir("${BACKEND_DIR}") {
                            script {
                                sh 'mvn clean package -DskipTests' // Build the backend
                                sh 'ls -lh target/' // Verify the JAR file is created
                            }
                        }
                    }
                }

                stage('Build Frontend') {
                    steps {
                        dir("${FRONTEND_DIR}") {
                            script {
                                sh '''
                                    rm -rf node_modules package-lock.json
                                    npm install
                                    npm run build
                                    ls -lh build/
                                '''
                            }
                        }
                    }
                }
            }
        }

        stage('Build & Start Services') {
            steps {
                script {
                    // This may fail if Jenkins doesn't have permission to access Docker socket
                    sh "$DOCKER_COMPOSE_CMD"
                }
            }
        }

        stage('Deployment') {
            steps {
                echo "✅ Application deployed successfully!"
            }
        }
    }
    
    post {
        failure {
            echo '❌ Pipeline failed.'
        }
        success {
            echo '🎉 Pipeline finished successfully.'
        }
        always {
            echo '🧹 Cleaning up after pipeline...'
        }
    }
}
