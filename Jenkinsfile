pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // GitHub에서 최신 코드를 가져옵니다.
                checkout scm
            }
        }

        stage('Test') {
            steps {
                // 파이썬 테스트 실행 (윈도우 환경에 맞춰 python 사용)
                // 여기서 실패(Exit Code 1)하면 Deploy 단계는 자동으로 건너뜁니다.
                bat 'python test_hello.py'
            }
        }

        stage('Deploy') {
            steps {
                // Test 단계가 성공했을 때만 이 메시지가 출력됩니다.
                echo '✅ 테스트 성공! 배포를 시작합니다.'
                
                // 간단한 배포 시뮬레이션: 별도의 폴더를 만들고 파일을 복사합니다.
                bat 'if not exist deploy_dist mkdir deploy_dist'
                bat 'copy hello.py deploy_dist\\'
                
                echo '🚀 배포 폴더(deploy_dist)로 파일 복사가 완료되었습니다.'
            }
        }
    }

    // 모든 단계가 끝난 후 실행되는 결과 처리 블록
    post {
        success {
            echo '🎉 축하합니다! 모든 빌드와 테스트, 배포가 성공적으로 완료되었습니다.'
        }
        failure {
            echo '❌ 빌드 또는 테스트 중에 문제가 발생했습니다. 로그를 확인해 주세요.'
        }
    }
}