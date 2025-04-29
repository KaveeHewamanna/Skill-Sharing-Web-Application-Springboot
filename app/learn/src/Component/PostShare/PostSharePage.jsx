import React, { useState } from 'react';
import '../../CSS Files/PostSharePage.css';


const PostSharePage = () => {
  const [caption, setCaption] = useState('');
  const [image, setImage] = useState(null);

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      setImage(URL.createObjectURL(file));
    }
  };

  const handleShare = () => {
    alert('Post shared successfully!');
    // Add your upload logic here
    setCaption('');
    setImage(null);
  };

  return (
    <div className="post-share-container">
      <h2 className="heading">Create Post</h2>
      <div className="card">
        <div className="profile">
          <img
            src="https://via.placeholder.com/40"
            alt="Profile"
            className="avatar"
          />
          <span className="username">your_username</span>
        </div>

        <textarea
          className="caption-input"
          placeholder="Write a caption..."
          value={caption}
          onChange={(e) => setCaption(e.target.value)}
        />

        {image && <img src={image} alt="Preview" className="preview-image" />}

        <input
          type="file"
          accept="image/*"
          className="file-input"
          onChange={handleImageChange}
        />

        <button className="share-button" onClick={handleShare}>
          Share
        </button>
      </div>
    </div>
  );
};

export default PostSharePage;
