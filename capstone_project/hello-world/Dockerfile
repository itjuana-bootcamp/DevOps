<<<<<<< HEAD
FROM node:alpine

WORKDIR /app

COPY package*.json ./
=======
FROM node:12

WORKDIR /app

COPY ./package.json ./
>>>>>>> c7b88c3e20c6f984567ef65169f3d8c8e5cd7a6b

RUN npm install

COPY . .

ENV PORT=3000

EXPOSE 3000

<<<<<<< HEAD
CMD [ "npm", "start" ]
=======
CMD [ "npm", "start" ]
>>>>>>> c7b88c3e20c6f984567ef65169f3d8c8e5cd7a6b
