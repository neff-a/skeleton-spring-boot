const path = require('path');

module.exports = {
	entry: './js/app.js',
	output: {
		filename: 'main.js',
		path: path.resolve(__dirname, 'dist')
	}
};