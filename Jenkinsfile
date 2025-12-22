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
            
           post 
    success {
        script {
            // 결과 파일이 있는지 확인 후 전송
            def xmlPath = "target/surefire-reports/TEST-testapp.junit.AppTest.xml"
            
            bat """
            curl -X POST "http://lcstc/polarion/rest/v1/projects/POC_GALAXAY_S26/testruns/789789/actions/importXUnitTestResults" ^
            -H "accept: application/json" ^
            -H "Authorization: Bearer eyJraWQiOiIzYjkxN2U0MS0wYTAwMDBmMy02MmNmOGZkYS1lN2MwMDMyZSIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJhZG1pbiIsImlkIjoiNDRmODUzNTEtMGEwMDAwZjMtMGJiYWY3MGYtMzkwZTk3OTkiLCJleHAiOjE3NzIyMDQ0MDAsImlhdCI6MTc2NjM4ODY4M30.KSB4UwfXSM9NhUf9GqZpDOhR1sqk0OIHH1V-YV-v3zpXg17rW4fiIpKM5EWhNrziNl9udO2oJhb6umxY2dGSc2H-HM5wclcZytiBa45M4Ltz996UblQ12rZ06ILYgj6Ms8af9-zWEZ7jrmHagCtsSGfuAesvddvzZftWKwG22dcogKfyhO2415z3b5NL-pP9-RrdsNeyZVOp9u0NoC_FKewhoFpr6Pd6tBYv4e49r7-nV5_WCLom8QFwQkLxlU_b1M3nJiFabvZgEJwCpeZh08vZ6auuoeYTCOzvz5jSYHLpKO-zxDv4giEF5Xhu5ldME0M1LBHYj4qqEa-1KcOUKw" ^
            -H "Content-Type: application/octet-stream" ^
            --data-binary "@${xmlPath}"
            """
        }
    }

        }
    }
}