FROM node:lts-alpine
ENV PORT=8080
WORKDIR /usr/src/app
COPY ["package.json", "package-lock.json*", "./"]
RUN npm install -g npm@8.5.1
RUN npm install --silent && mv node_modules ../
COPY . .
EXPOSE 8080
CMD npm start
