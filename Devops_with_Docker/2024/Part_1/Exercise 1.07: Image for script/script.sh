while true
do 
    echo "input website:"
    read website; echo "Searching..."
    sleep 1; curl http://$website
done
