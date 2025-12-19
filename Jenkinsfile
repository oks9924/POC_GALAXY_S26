pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // GitHub에서 코드를 가져옵니다.
                checkout scm
            }
        }
        stage('Test') {
            steps {
                // Python 테스트 실행
                // 윈도우 서버라면 'sh' 대신 'bat'를 사용하세요.
                bat 'python test_hello.py'
            }
        }
        stage('Deploy') {
            steps {
                echo '테스트를 통과하여 배포 준비가 되었습니다!'
            }
        }
    }
}