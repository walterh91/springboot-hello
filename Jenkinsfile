pipeline{
    agent any
    tools{
        maven 'Maven_3.5.3'
        jdk 'Java_1.8u161'
    }
     triggers {
        gitlab(triggerOnPush: true, triggerOnMergeRequest: false, branchFilterType: 'NameBasedFilter', includeBranchesSpec: "master", secretToken: 'e51e9dc243903bb5614b21e91fbfd931')
    }
    stages{
        stage('Clone repo'){
            steps{
                checkout scm
            }
        }
        stage('Clean test'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('Package'){
            steps{
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Eliminar contenedor anterior'){
            steps{
                script{
                    try{
                        sh 'docker -H 192.168.5.33 rm -f springboot-test'
                    }catch(Exception all){
                        echo "No habia contenedor con ese nombre"
                    }
                }    
            }
        }
        stage('Crear imagen Docker'){
            steps{
               sh 'docker -H 192.168.5.33 build -t springboot-wherrera .'
           }
        }
        stage('Run new Image'){
            steps{
                sh 'docker -H 192.168.5.33 run -p 8095:8080 -d --name springboot-test springboot-wherrera'
            }
        }
    }
    post{
        always{
            cleanWs()
        }
    }
}