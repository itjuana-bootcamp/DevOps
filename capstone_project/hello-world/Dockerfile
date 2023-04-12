FROM node:16.13.1
WORKDIR /hello-world
COPY package*.json ./
RUN npm install
COPY . .
CMD ["npm","start"]
EXPOSE 3000