front:

docker build -t app/front .  

docker run -p 8085:8085 --name front_app app/front


docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=us1 -e RABBITMQ_DEFAULT_PASS=pa1  rabbitmq:3.10-managemen


