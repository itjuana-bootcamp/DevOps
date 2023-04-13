FROM node
COPY . /app
WORKDIR /app/src
RUN npm install
RUN npm install package.json
CMD ["npm", "start"]
EXPOSE 3000
