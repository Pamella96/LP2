this.addMouseListener(
            new MouseAdapter() {
                public void mousePressed(MouseEvent evt){
                    mouse = getMousePosition();
                    selectedFigure = null;

                    for (int i = 0; i < figs.size(); i++){
                        if (figs.get(i).colision(mouse.x,mouse.y)) {
                            selectedFigure = figs.get(i); 
                        }
                        else{
                            figs.get(i).corBorda((0),(0),(0)); 
                     }        
                    }
                    

                    if (selectedFigure != null){ 
                        figs.remove(selectedFigure);
                        figs.add(selectedFigure);
                        selectedFigure.corBorda(255, 0, 0);
                    }
                    
                    repaint();
                }
            }
            );

            this.addMouseMotionListener( 
                new MouseAdapter() {
                    public void mouseDragged (MouseEvent evt) {
                        if(selectedFigure != null){
                            int dx = evt.getX() - mouse.x;
                            int dy = evt.getY() - mouse.y;
                            selectedFigure.drag(dx, dy);
                            repaint();
                        }
                        mouse = ((MouseEvent)evt).getPoint();
                    }
                }
            );