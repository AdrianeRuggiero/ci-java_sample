pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/share/maven'
    }

    tools {
        maven 'Maven 3.9.10'
        jdk 'jdk-11'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/AdrianeRuggiero/ci-java_sample.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=ci-java-sample \
                        -Dsonar.login=$SONAR_TOKEN \
                        -Dsonar.coverage.exclusions=**/Application.java,**/SumController.java \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                    '''
                }
            }
        }
    }
}
