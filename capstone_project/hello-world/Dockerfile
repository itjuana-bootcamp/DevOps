FROM node:16.13.1
WORKDIR /hello-world
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm","start"]
