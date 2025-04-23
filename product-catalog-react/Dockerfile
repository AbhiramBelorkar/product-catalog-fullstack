# Use Node.js image
FROM node:18

# Set the working directory in the container
WORKDIR /app

# Copy only the package.json first to leverage Docker caching
COPY package.json ./

# Install dependencies
RUN npm install

# Copy the rest of the frontend code
COPY . .

# Expose the port for the frontend
EXPOSE 3000

# Command to run the frontend
CMD ["npm", "start"]