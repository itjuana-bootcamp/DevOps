FROM node
WORKDIR /hello-world
COPY package*.json ./
RUN npm install
COPY . .
CMD ["node","src/index.js"]
EXPOSE 3000