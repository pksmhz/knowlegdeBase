front:

docker build -t app/front .  

docker run -p 8085:8085 --name front_app app/front


frontend backend:

docker build -t app/back . 

docker run -p 8085:8085 --name back_app app/back



Scan:
docker scout cves app/back
