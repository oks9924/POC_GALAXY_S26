pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                // 테스트 통과 여부 확인
                bat 'python test_hello.py'
            }
        }

        stage('Build EXE') {
            steps {
                echo '🛠️ 파이썬 파일을 EXE로 빌드 중...'
                // --onefile: 여러 파일을 하나의 exe로 합침
                // --noconsole: 실행 시 검은색 콘솔창이 뜨지 않게 함 (필요 시 추가)
                bat 'pyinstaller --onefile hello.py'
            }
        }

        stage('Deploy') {
            steps {
                echo '✅ 빌드 완료! 결과물을 정리합니다.'
                // 빌드된 exe 파일만 따로 모아두기
                bat 'if not exist deploy_dist mkdir deploy_dist'
                bat 'copy dist\\hello.exe deploy_dist\\'
            }
        }
    }

    post {
        success {
            echo '🎉 빌드 성공!'
            // 젠킨스 메인 화면에서 exe 파일을 바로 다운로드할 수 있게 보관합니다.
            archiveArtifacts artifacts: 'dist/*.exe', followSymlinks: false
        }
        failure {
            echo '❌ 빌드 실패'
        }
    }
}