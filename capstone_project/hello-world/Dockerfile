# Use an official Ubuntu runtime as the base image
FROM ubuntu

# Update the package list and install dependencies necessary for the app
RUN apt-get update -y \
    && apt-get upgrade -y \
    && apt-get install -y \
    ssh \
    sudo \
    software-properties-common \
    nodejs \
    npm

# Set the working directory in the container to /app
WORKDIR /app

# Copy the package.json and package-lock.json files into the container
COPY package*.json ./

# Install the app's dependencies
RUN npm install

# Copy the rest of the app's files into the container
COPY . .

# Create the react-container user and configure sudo
RUN useradd -rm -d /home/react-container -s /bin/bash -g root -G sudo -u 1001 react-container \
    && echo react-container:12345 | chpasswd \
    && echo "react-container ALL=(ALL:ALL) NOPASSWD: ALL" | EDITOR="tee -a" visudo \
    && mkdir -p /home/react-container/.ssh

# Start ssh service and React app, and keep container running
CMD service ssh start && npm start