pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📦 GitHub에서 최신 코드를 가져오는 중...'
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo '🧪 파이썬 단위 테스트 실행 중...'
                // 윈도우 환경에 맞춰 'python' 명령어를 사용합니다.
                // 테스트 실패 시 여기서 중단되며, 이후 단계는 실행되지 않습니다.
                bat 'python test_hello.py'
            }
        }

        stage('Build EXE') {
            steps {
                echo '🛠️ PyInstaller를 사용하여 EXE 파일 빌드 중...'
                // --onefile: 실행에 필요한 모든 파일을 하나로 합친 단일 EXE 생성
                bat 'pyinstaller --onefile hello.py'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 빌드된 파일을 배포용 폴더(deploy_dist)로 정리 중...'
                // 빌드 결과물인 dist 폴더 내 exe 파일을 별도의 배포 폴더로 복사
                bat 'if not exist deploy_dist mkdir deploy_dist'
                bat 'copy dist\\hello.exe deploy_dist\\'
            }
        }
    }

    // 모든 단계가 끝난 후 상태에 따라 실행되는 블록
    post {
        success {
            echo '🎉 모든 과정이 성공적으로 끝났습니다!'
            // [중요] 빌드된 EXE 파일을 젠킨스 화면에 보관하여 노출합니다.
            // 성공 시 Stage View 위쪽이나 대시보드에서 파일을 바로 다운로드할 수 있습니다.
            archiveArtifacts artifacts: 'dist/*.exe', followSymlinks: false
        }
        failure {
            echo '❌ 빌드 또는 테스트 중에 에러가 발생했습니다. Console Output을 확인해 주세요.'
        }
    }
}