version: "3"
services:
  controller:
    image: ngrinder/controller:3.5.9-p1
    ports:
      - "8080:80"
      - "16001:16001"
      - "13000-13009:12000-12009"
    volumes:
      - controller-data:/opt/ngrinder-controller
    restart: always

  agent:
    image: ngrinder/agent:3.5.9-p1
    volumes:
      - agent-data:/opt/ngrinder-agent
    depends_on:
      - controller
    restart: always

  jenkins:
    image: jenkins/jenkins:lts
    platform: linux/amd64
    user: root
    ports:
      - "8081:8080"
      - "50000:50000"
    volumes:
      - jenkins-data:/var/jenkins_home
    restart: always

  ngrok:
    image: ngrok/ngrok:latest
    container_name: ngrinder-ngrok
    restart: always
    environment:
      - NGROK_AUTHTOKEN=${NGROK_AUTHTOKEN}
    command: http jenkins:8080

volumes:
  controller-data:
  agent-data:
  jenkins-data:
