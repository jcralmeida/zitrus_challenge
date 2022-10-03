FROM node:11.13.0-alpine
ENV NODE_ENV=production

WORKDIR /build/

# update and install dependency
RUN apk update && apk upgrade
RUN apk add git

COPY . /build/
RUN npm install
RUN npm run build

EXPOSE 3000

ENV NUXT_HOST=0.0.0.0
ENV NUXT_PORT=3000

CMD npm start