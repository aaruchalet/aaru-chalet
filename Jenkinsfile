pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'java -version'
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
    }

    post {
        always {
            junit testResults: '**/build/test-results/test/*.xml', allowEmptyResults: true
        }

        success {
            echo 'Build completed successfully.'
        }

        failure {
            echo 'Build failed.'
        }
    }
}