stage('Full Test') {
    steps {
        // pytest 대신 maven을 사용 (윈도우 환경이므로 bat)
        bat 'mvn test' 
    }
}
post {
    always {
        // Maven의 기본 결과 경로를 지정
        junit '**/target/surefire-reports/*.xml'
        
        // Polarion 전송 시에도 실제 생성된 경로를 지정
        polarionReporter(
            targetProject: 'POC_GALAXY_S26',
            testRunTitle: "Full Test Result for Release ${params.RELEASE_ID}",
            testRunID: "TR_${params.RELEASE_ID}_${BUILD_NUMBER}",
            junitPath: 'target/surefire-reports/TEST-testapp.junit.AppTest.xml' // 또는 *.xml
        )
    }
}