# Capstone project

This is capstone project was solved by **_Lucila Andrade_**

You can see screenshots of my results on the directory called evidence inside the capstone_project

## Instructions

1.  Create the containers

From capstone_proyect/ansible-config execute the following command to compose the containers (ansible_controller and hello-world).

    docker compose up

this command will use the following **docker-compose.yml** file

    version: "3.9"
    services:
    ansible:
        build:
        context: ./ansible_base
        dockerfile: Dockerfile
        container_name: ansible_controller
        volumes:
        - type: bind
            source: ./ansible_files
            target: /home/ansible_controller/ansible_files
    target1:
        ports:
        - "3000:3000"
        build:
        context: ../hello-world
        dockerfile: dockerfile
        container_name: hello-world

The compose file uses the ansible_controller **Dockerfile** which looks as follows

    # Set the base image
    FROM ubuntu

    #Install ssh stuff
    RUN apt-get update  -y \
        && apt-get upgrade -y \
        && apt-get install -y \
        ssh \
        sshpass \
        sudo \
        software-properties-common

    #Install ansible
    RUN add-apt-repository --yes --update ppa:ansible/ansible \
        && apt-get install -y ansible

    #Creates and set the working directory
    WORKDIR /home/ansible_controller

    #Copy ssh script
    COPY startup.sh .

    #Set user and password
    RUN useradd -rm -d /home/ansible_controller -s /bin/bash -g root -G sudo -u 1001 ansible_controller
    RUN echo ansible_controller:12345 | chpasswd

    #Avoids asking for password
    RUN echo "ansible_controller ALL=(ALL:ALL) NOPASSWD: ALL" |  EDITOR="tee -a"  visudo

    #Creates .ssh dir
    RUN mkdir -p /home/ansible_controller/.ssh

    #Runs ssh script
    CMD ["/bin/bash", "/home/ansible_controller/startup.sh"]

It's **startup.sh** is this

    #!/bin/bash

    service ssh start
    tail -f /dev/null

The compose file also uses the hello-world app **dockerfile** that looks as follows

    #Autor: LAH
    #Version 1.0

    # Set the base image
    FROM node:16.13.1

    #Install ssh stuff
    RUN apt-get update  -y \
        && apt-get upgrade -y \
        && apt-get install -y \
        ssh \
        sshpass \
        sudo \
        software-properties-common

    #Creates and set the working directory
    WORKDIR /home/ansible_controller

    #Copy ssh script
    COPY startup.sh .

    # Copy the package.json and package-lock.json files to the container
    COPY package*.json ./

    # Copy the project files to the container
    COPY ./public ./public
    COPY ./src ./src

    #Install dependencies
    RUN npm install

    #Set user and password
    RUN useradd -rm -d /home/ansible_controller -s /bin/bash -g root -G sudo -u 1001 ansible_controller
    RUN echo ansible_controller:12345 | chpasswd

    #Avoids asking for password
    RUN echo "ansible_controller ALL=(ALL:ALL) NOPASSWD: ALL" |  EDITOR="tee -a"  visudo

    #Creates .ssh dir
    RUN mkdir -p /home/ansible_controller/.ssh

    #Runs ssh script and starts the hello-world app
    CMD ["/bin/bash", "/home/ansible_controller/startup.sh"]

It's **startup.sh** is this

    #!/bin/bash
    npm start &
    service ssh start
    tail -f /dev/null
    wait

2.  Execute the playbook

Once is running check if the react project is actually running on port 3000

Open the ansible container terminal

    docker exec -it ansible_controller /bin/sh

In this new terminal execute the following commands to run the playbook

    cd ansible_files
    ansible-playbook -i inventory.ini playbook.yml

This will use the inventory.ini to run the playbook.yml

The **inventory.ini** looks as follows

    [target1]
    hello-world ansible_user=ansible_controller ansible_password=12345

And the **playbook.yml** is the following

    ---
    - name: Ansible update for all host
    hosts: all
    become: true
    tasks:
        - name: Ping test to verify connectivity
        ping:

        - name: Update Hello World! to Hello DevOps!
        lineinfile:
            path: /home/ansible_controller/src/App.js
            regexp: '^\s*Hello World!\s*$'
            line: 'Hello DevOps!'
        register: lineinfile_result

        - name: Print lineinfile output
        debug:
            var: lineinfile_result

This will do the following

- Run a ping to the hello-world container
- Replace "Hello World!" for "Hello DevOps!" on the App.js file of the the hello-world container
- Print the lineinfile output
