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
