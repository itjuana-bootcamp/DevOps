# DevOps Bootcamp Capstone Project

## Capstone Project Resume 

### Using ansible in your `local computer` to change message app.
 I encountered some issues on MacOS when using the 'sudo docker compose up' command. It was a widespread error that I couldn't resolve, so I decided to leverage the power of Ansible to connect to the container from my local computer. But before that, I had to expose port 3000 and port 22 for make work this solution.

#### Step 1 - Build the image of ubuntu in Dockerfile inside Folder hello_world

```sh
  docker build -t gusqroo .
```
#### Step 2 - Create the container and expose port 22 & 3000.
```sh
  docker run -d -p 22:22 -p 3000:3000 gusqroo/app
```
 - ### NOTE: - Make sure you have install `sshpass` on your local computer. This Steap is necesary for run ansible-playbook command. In my case, i had to install vía **MacPorts** with the command:
 ```sh
sudo port install sshpass
```
#### Steap 3 - Go to  `ansible_files` directory on terminal, and open inventory.ini and add the ansible_port=22, like this:    
  ```[target1]
  localhost ansible_user=react-container ansible_password=12345 ansible_port=22
  ```
#### Steap 4 - Run comand for make changes in the app react on local machine:  

```sh
ansible-playbook -i inventory.ini playbook.yml
```
This will run the ansible playbook and make changes the message on `app.js` file in the `container` on execution time.

![Message Changed](https://i.ibb.co/JQMqHVY/Captura-de-Pantalla-2023-04-13-a-la-s-19-11-33.png)

## Another way to make the change is through a controller ansible in a container to the hello-world container, which can be done using the follow command in local:
**Steap 1
- Go to the folder capstone_project and run this command for build the `docker-composer.yml` this file contains instructions for creating two containers: hello-app and ansible_controller. Execute:
```sh
sudo docker compose up
```
**Steap 2
- Expose two ports 3000 y 22:
```sh
docker run -d -p 22:22 -p 3000:3000 hello-world
```
**Steap 3
- Enter to the controller container using the following command:
```sh
docker exec -w /home/ansible_controller/ansible_files/ -ti ansible_controller bash
```
**Steap 4
- Execute the Ansible command to change the message from "Hello World" to "Hello DevOps".
```sh
ansible-playbook -i inventory.ini playbook.yml
```
***All the configurations files for Ansible are located on this folder: 
[ansible_files](https://github.com/gusqroo/DevOps/tree/gusqroo/capstone_project/ansible/ansible_files)

## CI Pipeline with Github Actions.

All tests pass successfully. For more detail you can go to [gusqroo-workflow.yaml](https://github.com/gusqroo/DevOps/blob/gusqroo/.github/workflows/gusqroo-workflow.yaml "gusqroo-workflow.yaml")

![Pipeline CI/CD Successfully](https://i.ibb.co/9NfrzgK/Test-Deploy.png)

To carry out the deployment tests of the container to Docker Hub, 2 secrets had to be configured: DOCKERHUB_USERNAME and DOCKERHUB_ACCESS_TOKEN. 
The workflow deploys to Docker Hub and creates the image in our repository.
The image [Docker Hub]([gusqroo/app general | Docker Hub](https://hub.docker.com/repository/docker/gusqroo/app/general)) created for the workflow, you can pull the container with the command: 
```sh
docker push gusqroo/app:tagname
```

And thats all!

## Conclussions 💡

In general, this Bootcamp was very challenging, not only due to its level of complexity, but also because it was a real challenge to learn technologies that are part of everyday life and highly in demand in the job market. It was very exciting to learn from the tutors of the Bootcamp who were always there to help us with any questions during the classes.  This has been one of the best Bootcamps I have ever taken, and it was also my first one in English!

Thank You ITijuana.🤘

Regards!

**Gustavo Gómez** 

[LinkedIn](https://www.linkedin.com/in/gusqroo/)- [Email](mailto:gusqroo@gmail.com) - [GitHub](https://github.com/gusqroo) 
