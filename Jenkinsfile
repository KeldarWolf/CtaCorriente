pipeline {
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/KeldarWolf/CtaCorriente.git'
                echo 'Repositorio clonado correctamente'
            }
        }
        stage('Verificar Dependencias') {
            steps {
                echo 'Verificando dependencias del proyecto...'
                // Aquí puedes incluir comandos específicos de tu proyecto, como validar archivos o dependencias
            }
        }
        stage('Compilar Proyecto') {
            steps {
                echo 'Compilando el proyecto...'
                // Comando para compilar, por ejemplo:
                // sh './gradlew build' o 'mvn clean install'
            }
        }
        stage('Ejecutar Pruebas') {
            steps {
                echo 'Ejecutando pruebas del proyecto...'
                // Comando para ejecutar pruebas, por ejemplo:
                // sh './gradlew test'
            }
        }
        stage('Desplegar Proyecto') {
            steps {
                echo 'Desplegando la aplicación...'
                // Aquí puedes incluir comandos para desplegar, como copiar archivos a un servidor
            }
        }
    }
