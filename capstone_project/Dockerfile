FROM node:alpine
COPY ./hello-world /app
WORKDIR /app/hello-world/src
EXPOSE 3000
RUN npm install
CMD ["npm", "start"]
