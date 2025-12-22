pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/oks9924/POC_GALAXY_S26.git'
            }
        }
        stage('Test') {
            steps {
                // Java 프로젝트라면 mvn test가 맞습니다!
                bat 'mvn test' 
            }
        }
    }
    post {
        always {
            // 1. Jenkins 내부에 리포트 표시
            junit 'target/surefire-reports/*.xml'
            
            // 2. Polarion으로 전송 (경로와 프로젝트 ID 주의)
            polarionReporter(
                targetProject: 'POC_GALAXY_S26', 
                testRunTitle: "Build_${env.BUILD_NUMBER}",
                testRunID: "TR_${env.BUILD_NUMBER}",
                junitPath: 'target/surefire-reports/*.xml' // 패턴으로 지정 가능
            )
        }
    }
}