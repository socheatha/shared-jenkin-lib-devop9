def call(String projectKey, String projectName, String projectVersion){
    withSonarQubeEnv(credentialsId: 'SONAR_TOKEN', installationName: 'sonarqube-scanner') {
        script{
            sh """
                ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName="${projectName}" \
                -Dsonar.projectVersion=${projectVersion} \
            """       
        }
    }
}
