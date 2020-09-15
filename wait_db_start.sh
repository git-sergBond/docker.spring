#until  psql -h "database1" -U "postgres" -c '\l'
while ! curl http://database1:5432/ 2>&1 | grep '52'
do
  >&2 echo "Whait DB database1:5432"
  sleep 1
done
java -jar /app.jar