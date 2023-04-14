FROM ubuntu
RUN apt-get update -y \
    && apt-get upgrade -y \
    && apt-get install -y \
    ssh \
    sshpass \
    sudo \
    software-properties-common \
    nodejs \
    npm

COPY . /app
WORKDIR /app/src/
RUN npm install
RUN npm install package.json
RUN useradd -rm -d /home/ansible_controller -s /bin/bash -g root -G sudo -u 1001 ansible_controller
RUN echo ansible_controller:12345 | chpasswd
RUN echo "ansible_controller ALL=(ALL:ALL) NOPASSWD: ALL" | EDITOR="tee -a" visudo

RUN mkdir -p /home/ansible_controller/.ssh
 
CMD service ssh start && npm start

EXPOSE 3000
