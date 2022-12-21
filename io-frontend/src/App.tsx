import {useState} from "react";
import {Textarea, Box, Chip, Button, Text, Title} from "@mantine/core";
import axios from "axios";
import "./App.css";

const endpoint = "http://localhost:8080/transform";

type Transform = {
	text: string;
	checked: boolean;
};

function App() {
	const [text, setText] = useState("");
	const [transforms, setTransforms] = useState<Transform[]>([
		{
			text: "Upper",
			checked: false,
		},
		{
			text: "Lower",
			checked: false,
		},
		{
			text: "Capitalize",
			checked: false,
		},
	]);

	const handleTransform = () => {
		const activeTransforms = transforms
			.filter(transform => transform.checked)
			.map(transform => transform.text.toLowerCase());

		console.log(activeTransforms);

		axios
			.post(endpoint, {
				text: text,
				transforms: activeTransforms,
			})
			.then(resp => {
				console.log(resp);
				setText(resp.data.text);
			})
			.catch(err => {
				console.log(err);
			});
	};

	return (
		<div className="App">
			<Title order={2} className="title">
				Text transformer
			</Title>

			<Box
				sx={{
					display: "flex",
					margin: "100px 20px auto",
					width: "500px",
					justifyContent: "space-around",
				}}>
				{transforms.map(transform => (
					<Chip
						value={transform.text}
						checked={transform.checked}
						onChange={() => {
							const newTransforms = transforms.map(item => {
								if (item.text === transform.text) return {...item, checked: !transform.checked};
								return item;
							});

							setTransforms(newTransforms);
						}}>
						{transform.text}
					</Chip>
				))}
			</Box>

			<Textarea
				autosize
				minRows={4}
				label="Your text here"
				value={text}
				className="textarea"
				onChange={e => setText(e.currentTarget.value)}
			/>

			<Button
				variant="outline"
				color="violet"
				size="md"
				onClick={handleTransform}
				sx={{
					width: "150px",
					margin: "20px auto",
				}}>
				Transform
			</Button>
		</div>
	);
}

export default App;
