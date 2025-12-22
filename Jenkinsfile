pipeline {
    agent any
    parameters {
        string(name: 'RELEASE_ID', defaultValue: '', description: 'Polarion Release WI ID')
    }
    stages {
        stage('Checkout Main Branch') {
            steps {
                // 특정 커밋이 아닌, 항상 최신 Main 브랜치를 가져옵니다.
                git branch: 'main', url: 'https://github.com/oks9924/POC_GALAXY_S26.git'
            }
        }
        stage('Full Test') {
            steps {
                // 전체 소스 코드에 대해 테스트 수행
                bat 'pytest --junitxml=result.xml'
            }
        }
        stage('Deploy') {
            steps {
                // 테스트 성공 시 배포 로직 실행
                echo "Deploying Release ${params.RELEASE_ID}..."
                bat 'call scripts/deploy.bat'
            }
        }
    }
    post {
        always {
            // 결과를 폴라리온의 Test Run에 등록
            junit 'result.xml'
            archiveArtifacts artifacts: 'result.xml'
            
            // Polarion 플러그인을 통한 결과 전송
            polarionReporter(
                targetProject: 'POC_GALAXY_S26',
                testRunTitle: "Full Test Result for Release ${params.RELEASE_ID}",
                testRunID: "TR_${params.RELEASE_ID}_${BUILD_NUMBER}",
                junitPath: 'result.xml'
            )
        }
    }
}