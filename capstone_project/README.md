# DevOps Bootcamp Capstone Project
- [DevOps Bootcamp Capstone Project](#devops-bootcamp-capstone-project)
  - [Description](#description)
  - [Features and Requirements](#features-and-requirements)
  - [Guidelines](#guidelines)
  - [Resources](#resources)
  - [Pre-requisites](#pre-requisites)
  - [1. Setup your development environment](#1-setup-your-development-environment)
    - [Repository](#repository)
    - [Application](#application)
  - [2. Containerize the application](#2-containerize-the-application)
  - [3. Create a CI Pipeline](#3-create-a-ci-pipeline)
  - [4. Update "Hello World!" to "Hello DevOps!"](#4-update-hello-world-to-hello-devops)

## Description
In this project, you will be using some of the tools and technologies you have learned during the bootcamp.

## Features and Requirements
- Node Js application will be provided
- Containerization using docker
- CI pipeline using Github Actions (Including automated testing,build)
- Update the Node JS application content using Ansible

## Guidelines
- Instruction for the project will be available on Wednesday,26th January
- One week to deliver the project. Please deliver the project no later than Wednesday, 2nd February.
- Send the repo link or project to talent@itjuana.com
- After delivering the trainers will review the content, if you pass you’ll get a badge recognizing your knowledge as DevOps Engineer.
- You’ll know the results via email from the ITJ Talent Team.
- Any questions or comments, please post it in the [WhatsApp group](https://chat.whatsapp.com/KiirrKYAJ3SINrDn1pLZ7C)

## Resources
[Bootcamp Presentations](https://github.com/itjuana-bootcamp/DevOps/tree/main/Presentations)

## Pre-requisites

* [Docker](https://docs.docker.com/desktop/) installed
  * `docker --version` should show the docker version
* [Git](https://github.com/git-guides/install-git) installed
  * `git --version` should show the git version
* [Node JS](https://nodejs.org/en/download/package-manager/)
  * `npm version` should show the node version
* Have a [github account](https://github.com/join)
* Code editor of your preference - [VS Code](https://code.visualstudio.com/download) recommended

## 1. Setup your development environment

### Repository
- Go to the github repository https://github.com/itjuana-bootcamp/DevOps
- Fork the repository
NOTE: From here on, whenever we say repository , that refers to your forked repository.
- Clone the repository : `git clone git@github.com:<githubaccount>/DevOps.git`

### Application
- Go to folder `hello-world`
- Run `npm install` .
- Run `npm test` . All tests need to pass.
- Run `npm start` to run the application.
- Check http://localhost:3000 is reachable and displaying "Hello World!"

## 2. Containerize the application
- Using docker, containerize the application.
- Build the container and run it to make the application available on http://localhost:3000

## 3. Create a CI Pipeline 
- Create a CI pipeline which 
     - will trigger on push and on pull request
     - Run the tests
     - Only if tests are success, build the container

## 4. Update "Hello World!" to "Hello DevOps!"
- Update the node js application to display "Hello DevOps!" instead of "Hello World!" using ansible.

