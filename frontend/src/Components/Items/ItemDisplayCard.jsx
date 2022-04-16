import { Typography, CardActionArea } from "@mui/material";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import { useNavigate } from 'react-router-dom';
import { convertItemNameToParam } from './ItemsService'

function ItemDisplayCard(props) {
  let navigate = useNavigate();
  return (
    <>
    <div onClick={() => navigate("/item/" + convertItemNameToParam(props.name.toString()))}>
      <Card sx={{ maxWidth: 500 }}>
        <CardActionArea>
          <CardMedia
            component="img"
            height="300"
            image={props.productImgUrl}
          />
          <CardContent>
            <Typography variant="h5" component="div">
              {props.name}
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
      </div>
    </>
  );
}

export default ItemDisplayCard;
